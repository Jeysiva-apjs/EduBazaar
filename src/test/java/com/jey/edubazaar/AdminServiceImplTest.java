// package com.jey.edubazaar;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import com.jey.edubazaar.entity.Admin;
// import com.jey.edubazaar.exception.AdminNotFoundException;
// import com.jey.edubazaar.repository.AdminRepository;
// import com.jey.edubazaar.service.AdminService;
// import com.jey.edubazaar.service.AdminServiceImpl;

// public class AdminServiceImplTest {

//     private AdminRepository adminRepository;
//     private AdminService adminService;

//     @BeforeEach
//     public void setup() {
//         adminRepository = mock(AdminRepository.class);
//         adminService = new AdminServiceImpl(adminRepository);
//     }

//     @Test
//     public void testCreateAdmin() {
//         Admin admin = new Admin();
//         String expectedMessage = "Admin created successfully";

//         String actualMessage = adminService.createAdmin(admin);

//         assertEquals(expectedMessage, actualMessage);
//     }

//     @Test
//     public void testLoginAdmin_Success() {
//         String name = "admin";
//         String password = "password";
//         Admin admin = new Admin();
//         admin.setName(name);
//         admin.setPassword(password);
//         List<Admin> admins = new ArrayList<>();
//         admins.add(admin);

//         when(adminRepository.findAll()).thenReturn(admins);

//         String expectedMessage = "Logged in successfully";

//         String actualMessage = adminService.loginAdmin(name, password);

//         assertEquals(expectedMessage, actualMessage);
//     }

//     @Test
//     public void testLoginAdmin_AdminNotFound() {
//         String name = "admin";
//         String password = "password";
//         List<Admin> admins = new ArrayList<>();

//         when(adminRepository.findAll()).thenReturn(admins);

//         assertThrows(AdminNotFoundException.class, () -> {
//             adminService.loginAdmin(name, password);
//         });
//     }

//     @Test
//     public void testLoginAdmin_IncorrectPassword() {
//         String name = "admin";
//         String password = "password";
//         Admin admin = new Admin();
//         admin.setName(name);
//         admin.setPassword("wrongpassword");
//         List<Admin> admins = new ArrayList<>();
//         admins.add(admin);

//         when(adminRepository.findAll()).thenReturn(admins);

//         assertThrows(AdminNotFoundException.class, () -> {
//             adminService.loginAdmin(name, password);
//         });
//     }
// }