package com.cooksys.server;

import com.cooksys.server.entities.*;
import com.cooksys.server.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {

    private final UsersRepository usersRepository;

    private final TeamRepository teamRepository;

    private final ProjectsRepository projectsRepository;

    private final CompanyRepository companyRepository;

    private final AnnouncementsRepository announcementsRepository;

    @Override
    public void run(String... args) throws Exception {

        // Users //
        // --- User 1 ---
        Users user1 = new Users();
        user1.setUsername("User1");
        user1.setPassword("Password1");
        user1.setFirstName("Chris");
        user1.setLastName("Purnell");
        user1.setEmail("chrisPurnell@cooksys.com");
        user1.setPhone("111-111-1111");
        user1.setActive(true);
        user1.setIsAdmin(true);
        user1.setStatus("Eating Lobsters");

        // --- User 2 ---
        Users user2 = new Users();
        user2.setUsername("User2");
        user2.setPassword("Password2");
        user2.setFirstName("Will");
        user2.setLastName("Marttala");
        user2.setEmail("willMarttala@cooksys.com");
        user2.setPhone("222-222-2222");
        user2.setActive(true);
        user2.setIsAdmin(true);
        user2.setStatus("Jumping Over Mountains");

        // --- User 3 ---
        Users user3 = new Users();
        user3.setUsername("User3");
        user3.setPassword("Password3");
        user3.setFirstName("Frank");
        user3.setLastName("Fournier");
        user3.setEmail("frankFournier@cooksys.com");
        user3.setPhone("333-333-3333");
        user3.setActive(true);
        user3.setIsAdmin(true);
        user3.setStatus("Buying Ice Cream");

        // --- User 4 ---
        Users user4 = new Users();
        user4.setUsername("User4");
        user4.setPassword("Password4");
        user4.setFirstName("Shemaiah");
        user4.setLastName("Moss");
        user4.setEmail("shemaiahMoss@cooksys.com");
        user4.setPhone("444-444-4444");
        user4.setActive(true);
        user4.setIsAdmin(true);
        user4.setStatus("Fishing in Australia");

        // --- User 5 ---
        Users user5 = new Users();
        user5.setUsername("User5");
        user5.setPassword("Password5");
        user5.setFirstName("Chris");
        user5.setLastName("Shivers");
        user5.setEmail("chrisShivers@cooksys.com");
        user5.setPhone("555-555-5555");
        user5.setActive(true);
        user5.setIsAdmin(false);
        user5.setStatus("Muay Thai Training");

        // --- User 6 ---
        Users user6 = new Users();
        user6.setUsername("User6");
        user6.setPassword("Password6");
        user6.setFirstName("Helena");
        user6.setLastName("Makendengue");
        user6.setEmail("helenaMakendengue@cooksys.com");
        user6.setPhone("666-666-6666");
        user6.setActive(true);
        user6.setIsAdmin(false);
        user6.setStatus("Dancing in Paris");

        // --- User 7 ---
        Users user7 = new Users();
        user7.setUsername("User7");
        user7.setPassword("Password7");
        user7.setFirstName("Carrie");
        user7.setLastName("DeBardelaben");
        user7.setEmail("carrieDeBardelaben@cooksys.com");
        user7.setPhone("777-777-7777");
        user7.setActive(true);
        user7.setIsAdmin(false);
        user7.setStatus("Ice Skating");

        // Save And Flush
        usersRepository.saveAllAndFlush(Arrays.asList(user1, user2, user3, user4, user5, user6, user7));

        // Teams //
        Team team1 = new Team();
        team1.setName("Spring");
        team1.setDescription("Where it rains, it pours");

        Team team2 = new Team();
        team2.setName("Summer");
        team2.setDescription("Beach and BBQ next week");

        Team team3 = new Team();
        team3.setName("Autumn");
        team3.setDescription("Football Season");

        teamRepository.saveAllAndFlush(Arrays.asList(team1, team2, team3));

        // Company //
        Company company1 = new Company();
        company1.setName("CookSys");
        company1.setDescription("Innovative IT Labor Solutions");

        Company company2 = new Company();
        company2.setName("TalentLMS");
        company2.setDescription("Onboard, Train, Certify & More");

        companyRepository.saveAllAndFlush(Arrays.asList(company1, company2));

        // Projects //
        Projects project1 = new Projects();
        project1.setName("Dev Duel");
        project1.setDescription("Inspect and Duel at your convenience");
        project1.setActive(false);
        project1.setTeam(team1);

        Projects project2 = new Projects();
        project2.setName("Twitter API");
        project2.setDescription("Implementing an API that exposes operations for social media " +
                "data that resembles the conceptual model of Twitter");
        project2.setActive(true);
        project2.setTeam(team2);

        Projects project3 = new Projects();
        project3.setName("Who's who?");
        project3.setDescription("Guess who?");
        project3.setActive(true);
        project3.setTeam(team3);

        projectsRepository.saveAllAndFlush(Arrays.asList(project1, project2, project3));

        // Announcements //
        Announcements announcement1 = new Announcements();
        announcement1.setTitle("Drive in Movie Theatre");
        announcement1.setMessage("7PM CST Beauty and the Beast, tickets will be free.");
        announcement1.setAuthor(user5);

        Announcements announcement2 = new Announcements();
        announcement2.setTitle("Axe Throwing");
        announcement2.setMessage("9PM CST Axe Throwing at Axes Galore, bring your own axes!");
        announcement2.setAuthor(user3);

        announcementsRepository.saveAllAndFlush(Arrays.asList(announcement1, announcement2));

        // Joining Users to Teams and Company
        user1.setTeam(team1);
        user1.setCompany(company1);
        user2.setTeam(team1);
        user2.setCompany(company1);
        user3.setTeam(team2);
        user3.setCompany(company1);
        user4.setTeam(team2);
        user4.setCompany(company1);
        user5.setTeam(team2);
        user5.setCompany(company1);
        user6.setTeam(team3);
        user6.setCompany(company2);
        user7.setTeam(team3);
        user5.setCompany(company2);

        usersRepository.saveAllAndFlush(Arrays.asList(user1, user2, user3, user4, user5, user6, user7));

        // Joining Team to Company

        team1.setCompany(company1);
        team2.setCompany(company1);
        team3.setCompany(company2);

        teamRepository.saveAllAndFlush(Arrays.asList(team1, team2, team3));


    }
}
