drop table books;
drop table author;
drop table book_aut;
drop PROCEDURE `ins_proc`;

CREATE TABLE books (
     book_id INT NOT NULL AUTO_INCREMENT,
     title varchar(128) NOT NULL,
     abstract varchar(2000),
     PRIMARY KEY (book_id)
) ;

CREATE TABLE author (
     aut_id INT NOT NULL AUTO_INCREMENT,
     aut_name varchar(128) NOT NULL,
     PRIMARY KEY (aut_id)
) ;

create table book_aut(book_book_id int, aut_aut_id int);


DELIMITER // 
create PROCEDURE `ins_proc` (in title_in VARCHAR(128),in abstract_in VARCHAR(2000),in aut_name_in varchar(128)) 
BEGIN 
declare book_id_var int;
declare aut_id_var int;

insert into books (title, abstract) values (title_in, abstract_in); 
commit;
select last_insert_id() into book_id_var from dual;
select aut_id into aut_id_var from author where lower(aut_name)=lower(aut_name_in);
if aut_id_var is null
then
insert into author (aut_name) values (aut_name_in);
select last_insert_id() into aut_id_var from dual;
end if;
insert into book_aut(book_book_id,aut_aut_id) values (book_id_var,aut_id_var);
commit;
END //


call ins_proc("Nineteen Eighty-Four","Nineteen Eighty-Four is a dystopian[1] novel by George Orwell published in 1949. The Oceanian province of Airstrip One (formerly known as Great Britain) is a world of perpetual war, omnipresent government surveillance, and public mind control, dictated by a political system euphemistically named English Socialism (Ingsoc) under the control of a privileged Inner Party elite that persecutes all individualism and independent thinking as thoughtcrimes.[2] Their tyranny is headed by Big Brother, the quasi-divine Party leader who enjoys an intense cult of personality, but who may not even exist. Big Brother and the Party justify their rule in the name of a supposed greater good.[1] The protagonist of the novel, Winston Smith, is a member of the Outer Party who works for the Ministry of Truth (Minitrue), which is responsible for propaganda and historical revisionism. His job is to re-write past newspaper articles so that the historical record always supports the current party line.[3] Smith is a diligent and skillful worker, but he secretly hates the Party and dreams of rebellion against Big Brother.","George Orwell");

call ins_proc("The Sleeper Awakes","The Sleeper Awakes (1910) is a dystopian novel by H. G. Wells about a man who sleeps for two hundred and three years, waking up in a completely transformed London, where, because of compound interest on his bank accounts, he has become the richest man in the world. The main character awakes to see his dreams realized, and the future revealed to him in all its horrors and malformities.","Herbert George Wells");

call ins_proc("Flowers for Algernon","Flowers for Algernon is a science fiction short story and subsequent novel written by Daniel Keyes. The short story, written in 1958 and first published in the April 1959 issue of The Magazine of Fantasy & Science Fiction, won the Hugo Award for Best Short Story in 1960.","Daniel Keyes");

call ins_proc("The Time Machine","The Time Machine is a science fiction novella by H. G. Wells, published in 1895 and later adapted into two feature films of the same name, as well as two television versions, and a large number of comic book adaptations. It indirectly inspired many more works of fiction in many media. This story is generally credited with the popularisation of the concept of time travel using a vehicle that allows an operator to travel purposefully and selectively. The term ""time machine"", coined by Wells, is now universally used to refer to such a vehicle. This work is an early example of the Dying Earth subgenre.","Herbert George Wells");

call ins_proc("Animal Farm","Animal Farm is an allegorical and dystopian novel by George Orwell, published in England on 17 August 1945. According to Orwell, the book reflects events leading up to the Russian Revolution of 1917 and then on into the Stalin era in the Soviet Union.","George Orwell");

call ins_proc("Alice's Adventures in Wonderland","Alice's Adventures in Wonderland (commonly shortened to Alice in Wonderland) is an 1865 novel. Written by English author Charles Lutwidge Dodgson under the pseudonym Lewis Carroll.","Lewis Carroll");


