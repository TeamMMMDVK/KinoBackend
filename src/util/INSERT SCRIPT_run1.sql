USE kinoxp;

-- Indsæt primære entiteter
INSERT INTO image (name, image, saved) VALUES 
('image_flow','https://poster.ebillet.dk/FLOW-CITATPLAKAT-2025.large.jpg','2025-03-05'), 
('image_A Complete Unknown','https://poster.ebillet.dk/a-complete-unknown-2025.large.jpg','2025-03-05'), 
('image_theend','https://poster.ebillet.dk/theend2024.hd.jpg','2025-03-05');

INSERT INTO customer (full_name, email) VALUES 
('John Doe', 'john@example.com'),
('Hans Hansen', 'hans@example.com'),
('Ole Olesen', 'ole@example.com'),
('Jane Smith', 'jane@example.com');

INSERT INTO ticket (ticket_type, price) VALUES 
('Adult', 100.00), 
('Student', 80.00), 
('Child', 50.00);

-- Indsæt afhængige entiteter
INSERT INTO movie (title, genre, duration_min, age_restriction, trailer_link, description, review_link, imageidfk) VALUES 
('Flow', 'ANIMATION', 84, 'PG_7', 'https://admin.ebillet.dk/trailers/34764.mp4', '"Flow" is a unique, visually beautiful and emotional animation film, which largely lets the animals act and behave as animals do in nature.','https://www.imdb.com/title/tt4772188/ratings/?ref_=tt_ov_rat', 1),
('A Complete Unknown', 'DRAMA', 141, 'PG_7', 'https://www.imdb.com/video/vi2538325529/?ref_=nv_sr_srsg_2_tt_7_nm_0_in_0_q_a%20complete', 'The true story of one of historys most iconic singer-songwriters.','https://www.imdb.com/title/tt11563598/ratings/?ref_=tt_ov_rat', 2),
('The End', 'MUSICAL', 148, 'PG_16', 'https://www.youtube.com/watch?v=avvm0e4oNCE', 'A touching and deeply human musical about a family that has survived the end of the world.', 'https://www.imdb.com/title/tt15551346/ratings/?ref_=tt_ov_rat', 3);

INSERT INTO theater (theater_name, total_amount_of_rows, seats_per_row) VALUES 
('Sal 1', 25, 16), 
('Sal 2', 20, 12);

