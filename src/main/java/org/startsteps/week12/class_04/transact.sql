CREATE TABLE Courses
(
    ID                INT AUTO_INCREMENT PRIMARY KEY,
    CourseName        VARCHAR(255),
    CourseDescription VARCHAR(255)
);

CREATE TABLE Themes
(
    ID        INT AUTO_INCREMENT PRIMARY KEY,
    ThemeName VARCHAR(255),
    CourseID  INT,
    FOREIGN KEY (CourseID) REFERENCES Courses (ID)
);
