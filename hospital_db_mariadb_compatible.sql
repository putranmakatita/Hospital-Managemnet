-- Compatible SQL for MariaDB/MySQL 5.7+
DROP DATABASE IF EXISTS hospital_db;
CREATE DATABASE hospital_db CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE hospital_db;

CREATE TABLE appointments (
 id INT NOT NULL AUTO_INCREMENT,
 patient_name VARCHAR(255) NOT NULL,
 doctor_name VARCHAR(255) NOT NULL,
 appointment_date DATE DEFAULT NULL,
 appointment_time TIME DEFAULT NULL,
 reason TEXT,
 status ENUM('Scheduled','Completed','Cancelled','No Show') DEFAULT NULL,
 PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO appointments VALUES
(1,'Zainab Shah','Dr. Ahmed Khan','2024-08-01','10:00:00','Regular Checkup','Scheduled'),
(2,'Ali Raza','Dr. Fatima Ali','2024-08-02','11:30:00','Follow-up','Completed'),
(3,'Amina Siddiqui','Dr. Ayesha Hussain','2024-08-03','09:00:00','Consultation','Cancelled'),
(4,'Usman Farooq','Dr. Salman Sheikh','2024-08-04','14:00:00','Routine Check','No Show'),
(5,'Nida Javed','Dr. Sana Malik','2024-08-05','15:00:00','Health Check','Scheduled');

CREATE TABLE doctors (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(255) NOT NULL,
 specialty VARCHAR(255),
 phone_number VARCHAR(15),
 email VARCHAR(255),
 gender ENUM('Male','Female','Other'),
 years_of_experience INT,
 status ENUM('Active','Inactive'),
 start_time TIME,
 end_time TIME,
 PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO doctors VALUES
(1,'Dr. Ahmed Khan','Cardiology','0300-1234567','ahmed.khan@example.com','Male',15,'Active','08:00:00','16:00:00'),
(2,'Dr. Fatima Ali','Pediatrics','0301-2345678','fatima.ali@example.com','Female',10,'Active','09:00:00','17:00:00'),
(3,'Dr. Ayesha Hussain','Dermatology','0302-3456789','ayesha.hussain@example.com','Female',8,'Inactive','10:00:00','18:00:00'),
(4,'Dr. Salman Sheikh','Neurology','0303-4567890','salman.sheikh@example.com','Male',12,'Active','07:00:00','15:00:00'),
(5,'Dr. Sana Malik','Orthopedics','0304-5678901','sana.malik@example.com','Female',7,'Inactive','11:00:00','19:00:00'),
(7,'fahad','Neurology','0234241','fahad@kamboh','Male',11,'Inactive','00:50:35','00:50:35');

CREATE TABLE medicines (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(255) NOT NULL,
 manufacturer VARCHAR(255),
 expiration_date DATE,
 dosage VARCHAR(255),
 stock INT,
 status ENUM('Available','Out of Stock'),
 PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO medicines VALUES
(1,'Panadol','GSK','2025-12-31','500mg',100,'Available'),
(2,'Brufen','Abbott','2024-06-30','400mg',50,'Available'),
(3,'Amoxicillin','Pfizer','2023-09-15','250mg',0,'Out of Stock'),
(4,'Cough Syrup','Reckitt Benckiser','2024-11-01','10ml',75,'Available'),
(5,'Vitamin D','Searle','2025-03-20','1000IU',200,'Available');

CREATE TABLE patients (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(255) NOT NULL,
 date_of_birth DATE,
 gender ENUM('Male','Female','Other'),
 phone_number VARCHAR(15),
 email VARCHAR(255),
 address TEXT,
 diagnosis TEXT,
 treatment_status ENUM('Ongoing','Completed','Pending','Discontinued'),
 status ENUM('Active','Inactive'),
 PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO patients VALUES
(1,'Zainab Shah','1985-03-15','Female','0310-1234567','zainab.shah@example.com','123 Elm St, Karachi','Hypertension','Ongoing','Active'),
(2,'Ali Raza','1978-06-21','Male','0311-2345678','ali.raza@example.com','456 Oak St, Lahore','Diabetes','Completed','Active'),
(3,'Amina Siddiqui','1992-11-08','Female','0312-3456789','amina.siddiqui@example.com','789 Pine St, Islamabad','Asthma','Pending','Inactive'),
(4,'Usman Farooq','2000-01-30','Male','0313-4567890','usman.farooq@example.com','321 Maple St, Peshawar','Allergy','Discontinued','Active'),
(5,'Nida Javed','1989-09-25','Female','0314-5678901','nida.javed@example.com','654 Cedar St, Quetta','Anemia','Ongoing','Inactive');

CREATE TABLE users (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(255) NOT NULL,
 email VARCHAR(255) NOT NULL,
 password VARCHAR(255) NOT NULL,
 PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO users VALUES
(1,'basit','basit@gmail.com','basit123');
