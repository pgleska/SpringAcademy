DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL UNIQUE,  
  `student_id` int NOT NULL UNIQUE,  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,      
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `teacher_id` int NOT NULL,       
  PRIMARY KEY (`id`),
  FOREIGN KEY (teacher_id) REFERENCES teacher(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  PRIMARY KEY (`student_id`, `course_id`)
) ENGINE=InnoDB;


INSERT INTO `student`(`email`, `student_id`) VALUES
('jan.kowalski@student.put.poznan.pl', 150010),
('anna.nowak@student.put.poznan.pl', 150020),
('piotr.kowalski@student.put.poznan.pl', 150013),
('joanna.nowak@student.put.poznan.pl', 150023),
('andrzej.kowalski@student.put.poznan.pl', 150015),
('katarzyna.nowak@student.put.poznan.pl', 150025),
('marek.kowalski@student.put.poznan.pl', 150017),
('agata.nowak@student.put.poznan.pl', 150027),
('marcin.kowalski@student.put.poznan.pl', 150019),
('wiktoria.nowak@student.put.poznan.pl', 150029),
('wiktor.kowalski@student.put.poznan.pl', 150011),
('ewa.nowak@student.put.poznan.pl', 150021),
('filip.kowalski@student.put.poznan.pl', 150012),
('aleksandra.nowak@student.put.poznan.pl', 150022),
('tomasz.kowalski@student.put.poznan.pl', 150014),
('zuzanna.nowak@student.put.poznan.pl', 150024),
('jeremi.kowalski@student.put.poznan.pl', 150016),
('alicja.nowak@student.put.poznan.pl', 150026),
('grzegorz.kowalski@student.put.poznan.pl', 150018),
('kinga.nowak@student.put.poznan.pl', 150028),
('oskar.kowalski@student.put.poznan.pl', 150030),
('julita.nowak@student.put.poznan.pl', 150040),
('jakub.kowalski@student.put.poznan.pl', 150031),
('sylwia.nowak@student.put.poznan.pl', 150041),
('mariusz.kowalski@student.put.poznan.pl', 150032),
('marta.nowak@student.put.poznan.pl', 150042);

INSERT INTO `teacher`(`first_name`, `last_name`) VALUES
('John', 'Doe');

INSERT INTO `course`(`name`, `teacher_id`) VALUES
('Cybersecurity', 1),
('Artificial Intelligence', 1),
('Digital Forensics', 1);

INSERT INTO `student_course`(`student_id`, `course_id`) VALUES
(1, 1),
(3, 1),
(5, 1),
(7, 1),
(10, 1),
(12, 1),
(14, 1),
(16, 1),
(18, 1);

