
<<<<<<<<<<<<<<<<<<<<<<<<Read>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Step by Step

0. Save mysql-connector to ....//---C:\Program Files (x86)\Java\jre1.8.0_261\lib\ext\mysql-connector.jar

1. Create database name "virtual_assistant"...//---create database virtual_assistant;

2. Create table name "greetings"...//---CREATE TABLE greetings (formal VARCHAR(100), informal VARCHAR(300));

3. Create table name "learn_new"...//---CREATE TABLE learn_new (comand VARCHAR(100) primary key, google_url VARCHAR(100));

4. Create table name "login"...//---CREATE TABLE login (email VARCHAR(50) primary key, password VARCHAR(20));

5. Create table name "registration"...//---CREATE TABLE registration (first_name VARCHAR(50), last_name VARCHAR(50), dateOfbirth VARCHAR(50), nation VARCHAR(30), gender VARCHAR(10), email VARCHAR(50) primary key, password VARCHAR(30));

6. Create table name "user_query"...//---CREATE TABLE user_query (query VARCHAR(100) primary key, answer VARCHAR(300));

7. Create table name "web_command"...//---CREATE TABLE web_command (url VARCHAR(500), command VARCHAR(100) primary key);

8. Create table name "launch_app"...//---CREATE TABLE launch_app (app_name VARCHAR(100) primary key, location VARCHAR(500));

<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

INSERT INTO `greetings` (`formal`, `informal`) VALUES ('aladdin', 'The princess of Agrabah, with the help of Genie.'), ('what can you do?', 'I can help with your schedule, give you reminders, find info, and more.');
INSERT INTO `greetings` (`formal`, `informal`) VALUES ('how are you?', 'All good here. When the unexpected happens, I can cancel your next meeting. Just ask.');

INSERT INTO `web_command`(`url`, `command`) VALUES ('www.bubt.edu.bd','bubt'), ('https://www.bubt.edu.bd/Home/page_details/BUBT_Administration','bubt administration'), ('https://www.bubt.edu.bd/Home/all_notice', 'bubt all notice'), ('https://www.bubt.edu.bd/Home/page_details/Campus', 'bubt campus'), ('https://www.google.com', 'google'), ('https://www.spacex.com', 'spacex'), ('https://www.bubt.edu.bd/department/information/cse', 'teachers of bubt'), ('https://www.time.com', 'time'), ('https://www.bubt.edu.bd/Home/page_details/Tuition_Fees', 'tuition fees of bubt'), ('https://www.uber.com', 'uber');

INSERT INTO `launch_app` (`app_name`, `location`) VALUES ('power point', 'C:\\Program Files\\Microsoft Office\\Office16\\POWERPNT.exe'), ('word', 'C:\\Program Files\\Microsoft Office\\Office16\\WINWORD.exe');
INSERT INTO `launch_app` (`app_name`, `location`) VALUES ('notepad', 'notepad.exe'), ('paint', 'mspaint.exe');
INSERT INTO `launch_app` (`app_name`, `location`) VALUES ('snipping tool', 'SnippingTool.exe');




//