-- =========================================
-- CAREERVAULT DATABASE
-- =========================================

CREATE DATABASE career_vault;

USE career_vault;

-- =========================================
-- USERS TABLE
-- =========================================
CREATE TABLE users
(
user_id INT PRIMARY KEY AUTO_INCREMENT,
user_name VARCHAR(255) NOT NULL,
phone VARCHAR(15) NOT NULL ,
email VARCHAR(200) ,
linkedin VARCHAR(255),
gitHub VARCHAR(300)
);

-- =========================================
-- EDUCATION TABLE
-- =========================================
CREATE TABLE education
(
education_id INT PRIMARY KEY AUTO_INCREMENT ,
user_id INT NOT NULL ,
degree VARCHAR(200) ,
branch VARCHAR(200),
college_name VARCHAR(250),
start_date DATE ,
end_date DATE ,
cgpa DECIMAL(3,2),
backlogs int ,
FOREIGN KEY (user_id)  REFERENCES users(user_id)
);

-- =========================================
-- SKILLS TABLE
-- =========================================
CREATE TABLE skills (
    skill_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    skill_name VARCHAR(100) NOT NULL,
    skill_level VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- =========================================
-- PROJECTS TABLE
-- =========================================
CREATE TABLE projects (
    project_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    project_title VARCHAR(200) NOT NULL,
    description TEXT,
    github_url VARCHAR(255),
    technologies VARCHAR(500),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- =========================================
-- EXPERIENCE TABLE
-- =========================================
CREATE TABLE experience (
    experience_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    company_name VARCHAR(200) NOT NULL,
    role VARCHAR(150) NOT NULL,
    start_date DATE,
    end_date DATE,
    FOREIGN KEY (user_id) REFERENCES users(user_id));

-- =========================================
-- CERTIFICATES TABLE
-- =========================================
CREATE TABLE certificates (
    certificate_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    certificate_name VARCHAR(200) NOT NULL,
    issuing_company VARCHAR(200),
    issue_date DATE,
    credential_id VARCHAR(150),
    url VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- =========================================
-- APPLICATIONS TABLE
-- =========================================
 CREATE TABLE applications (
    application_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    company_name VARCHAR(200) NOT NULL,
    job_role VARCHAR(150) NOT NULL,
    status VARCHAR(50) NOT NULL,
    applied_date DATE,
    interview_date DATE,
    notes TEXT,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);