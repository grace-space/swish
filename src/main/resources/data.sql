INSERT INTO game (game_id, description, img_url, msrp, rating, title) VALUES(1, 'Get ready for a new kind of grand, Pokémon adventure in Pokémon™ Legends: Arceus, a new game from Game Freak that blends action and exploration with the RPG roots of the Pokémon series.', 'https://www.nintendo.com/my/switch/aw7k/img/hero_sp.jpg', 59.99, 8.0, 'Pokemon Legends');
INSERT INTO game (game_id, description, img_url, msrp, rating, title) VALUES(2, 'Start your engines and gear up for the ultimate racing experience in Cars 3: Driven to Win inspired by Disney Pixar''s film, Cars 3. Play with over 20 customizable characters including Lightning McQueen, Jackson Storm, Cruz Ramirez and the next generation of racers in over 20 tracks set in iconic locations from the film such as Radiator Springs. 

Train and advance your abilities in 6 game modes and challenge your family and friends in the Battle Race to become the Ultimate Champion. On the road to becoming a Hall of Fame Driver, training and skill will give you an edge in a race that anyone can win.', 'https://www.gamesknit.com/wp-content/uploads/2020/01/Cars-3-Driven-to-win-PC.png', 59.99, 10.0, 'Cars 3: Driven to Win');
INSERT INTO game (game_id, description, img_url, msrp, rating, title) VALUES(3, 'Enter the Splatlands, a sun-scorched desert inhabited by battle-hardened Inklings and Octolings. Splatsville, the city of chaos, is the adrenaline-fueled heart of this dusty wasteland. 

Even in this desolate environment, Turf War* reigns supreme and battles rage in new stages located in the surrounding wilds. Dynamic new moves help these fighters dodge attacks and cover more ground, along with a new bow-shaped weapon to sling ink. ', 'https://www.nintendo.com/ph/switch/av5j/img/hero_sp.jpg', 59.99, 9.0, 'Splatoon 3');
INSERT INTO game (game_id, description, img_url, msrp, rating, title) VALUES(4, 'Factorio is a game in which you build and maintain factories.
You will be mining resources, researching technologies, building infrastructure, automating production, and fighting enemies. Use your imagination to design your factory, combine simple elements into ingenious structures, apply management skills to keep it working, and protect it from the creatures who don''t really like you.', 'https://assets.nintendo.com/image/upload/f_auto/q_auto/dpr_2.625/c_scale,w_400/ncom/en_US/games/switch/f/factorio-switch/description-image', 30.0, 10.0, 'Factorio');
INSERT INTO game (game_id, description, img_url, msrp, rating, title) VALUES(5, 'Help Madeline survive her journey to the top of Celeste Mountain in this super-tight, hand-crafted platformer from the creators of TowerFall.', 'https://assets.nintendo.com/image/upload/ar_16:9,b_auto:border,c_lpad/b_white/f_auto/q_auto/dpr_2.625/c_scale,w_500/ncom/en_US/games/switch/c/celeste-switch/hero', 30.0, 10.0, 'Celeste');
INSERT INTO game (game_id, description, img_url, msrp, rating, title) VALUES(6, 'Forge your own path in Hollow Knight! An epic action adventure through a vast ruined kingdom of insects and heroes. Explore twisting caverns, battle tainted creatures and befriend bizarre bugs, all in a classic, hand-drawn 2D style.', 'https://upload.wikimedia.org/wikipedia/en/c/c0/Hollow_Knight_cover.jpg', 30.0, 10.0, 'Hollow Knight');
INSERT INTO game (game_id, description, img_url, msrp, rating, title) VALUES(7, 'The job gets lively when your assigned soul is stolen and you must track down a desperate thief to a realm untouched by death - where creatures grow far past their expiry and overflow with greed and power.

Talon Sharp Combat: Utilize melee weapons, arrows and magic to overcome a fantastic array of beasts and demigods. Mistakes are punished and victory is rewarded. Gain an edge by customizing your character stats and mastering the abilities and upgrades you obtain.', 'https://store-images.s-microsoft.com/image/apps.47652.13892871097033903.6bf68087-15c2-4acb-aa8d-2a9356aea7ff.3d50dfc0-4252-40d9-972c-c5b79db4ad70', 30.0, 9.0, 'Death''s Door');
INSERT INTO game (game_id, description, img_url, msrp, rating, title) VALUES(8, 'Cuphead is a classic run and gun action game heavily focused on boss battles. Inspired by cartoons of the 1930s, the visuals and audio are painstakingly created with the same techniques of the era: traditional hand drawn cel animation, watercolor backgrounds, and original jazz recordings.

Play as Cuphead or Mugman (in single player or local co-op) as you traverse strange worlds, acquire new weapons, learn powerful super moves, and discover hidden secrets while you try to pay your debt back to the devil!', 'https://d1fs8ljxwyzba6.cloudfront.net/assets/article/2019/05/06/cuphead-eshop-sales_feature.jpg', 30.0, 9.0, 'Cuphead');


INSERT INTO format (format_id, format_type) VALUES(1, 'Digital');
INSERT INTO format (format_id, format_type) VALUES(2, 'Physical');
INSERT INTO format (format_id, format_type) VALUES(3, 'Special Edition');


INSERT INTO genre (genre_id, genre_name) VALUES(1, 'Platformer');
INSERT INTO genre (genre_id, genre_name) VALUES(2, 'Shooter');
INSERT INTO genre (genre_id, genre_name) VALUES(3, 'Fighting');
INSERT INTO genre (genre_id, genre_name) VALUES(4, 'Racing');
INSERT INTO genre (genre_id, genre_name) VALUES(5, 'Metroidvania');
INSERT INTO genre (genre_id, genre_name) VALUES(6, 'Role-playing');
INSERT INTO genre (genre_id, genre_name) VALUES(7, 'Simulation');
INSERT INTO genre (genre_id, genre_name) VALUES(8, 'Roguelike');


INSERT INTO multiplayer (multiplayer_id, multiplayer_type) VALUES(1, 'Singleplayer');
INSERT INTO multiplayer (multiplayer_id, multiplayer_type) VALUES(2, 'Online Multiplayer');
INSERT INTO multiplayer (multiplayer_id, multiplayer_type) VALUES(3, 'Local Multiplayer');
INSERT INTO multiplayer (multiplayer_id, multiplayer_type) VALUES(4, 'Online Co-op');
INSERT INTO multiplayer (multiplayer_id, multiplayer_type) VALUES(5, 'Local Co-op');


INSERT INTO retailer (retailer_id, retailer_name) VALUES(1, 'Digital Only');
INSERT INTO retailer (retailer_id, retailer_name) VALUES(2, 'Retail');
INSERT INTO retailer (retailer_id, retailer_name) VALUES(3, 'Limited Run Games');
INSERT INTO retailer (retailer_id, retailer_name) VALUES(4, 'Special Reserve Games');

INSERT INTO platform (platform_id, platform_name) VALUES(1, 'PC');
INSERT INTO platform (platform_id, platform_name) VALUES(2, 'Nintendo Switch');




INSERT INTO game_format (game_id, format_id) VALUES(1, 1);
INSERT INTO game_format (game_id, format_id) VALUES(1, 2);
INSERT INTO game_format (game_id, format_id) VALUES(2, 1);
INSERT INTO game_format (game_id, format_id) VALUES(2, 2);
INSERT INTO game_format (game_id, format_id) VALUES(3, 1);
INSERT INTO game_format (game_id, format_id) VALUES(3, 2);
INSERT INTO game_format (game_id, format_id) VALUES(4, 1);
INSERT INTO game_format (game_id, format_id) VALUES(4, 2);
INSERT INTO game_format (game_id, format_id) VALUES(5, 1);
INSERT INTO game_format (game_id, format_id) VALUES(5, 2);
INSERT INTO game_format (game_id, format_id) VALUES(6, 1);
INSERT INTO game_format (game_id, format_id) VALUES(6, 2);
INSERT INTO game_format (game_id, format_id) VALUES(7, 1);
INSERT INTO game_format (game_id, format_id) VALUES(7, 2);
INSERT INTO game_format (game_id, format_id) VALUES(8, 1);
INSERT INTO game_format (game_id, format_id) VALUES(8, 2);


INSERT INTO game_genres (game_id, genre_id) VALUES(1, 6);
INSERT INTO game_genres (game_id, genre_id) VALUES(2, 4);
INSERT INTO game_genres (game_id, genre_id) VALUES(3, 2);
INSERT INTO game_genres (game_id, genre_id) VALUES(4, 7);
INSERT INTO game_genres (game_id, genre_id) VALUES(5, 1);
INSERT INTO game_genres (game_id, genre_id) VALUES(6, 5);
INSERT INTO game_genres (game_id, genre_id) VALUES(7, 8);
INSERT INTO game_genres (game_id, genre_id) VALUES(8, 1);


INSERT INTO game_multiplayer (game_id, multiplayer_id) VALUES(1, 1);
INSERT INTO game_multiplayer (game_id, multiplayer_id) VALUES(2, 1);
INSERT INTO game_multiplayer (game_id, multiplayer_id) VALUES(3, 1);
INSERT INTO game_multiplayer (game_id, multiplayer_id) VALUES(4, 1);
INSERT INTO game_multiplayer (game_id, multiplayer_id) VALUES(5, 1);
INSERT INTO game_multiplayer (game_id, multiplayer_id) VALUES(6, 1);
INSERT INTO game_multiplayer (game_id, multiplayer_id) VALUES(7, 1);
INSERT INTO game_multiplayer (game_id, multiplayer_id) VALUES(8, 1);


INSERT INTO game_platforms (game_id, platform_id) VALUES(1, 2);
INSERT INTO game_platforms (game_id, platform_id) VALUES(2, 2);
INSERT INTO game_platforms (game_id, platform_id) VALUES(3, 2);
INSERT INTO game_platforms (game_id, platform_id) VALUES(4, 2);
INSERT INTO game_platforms (game_id, platform_id) VALUES(5, 2);
INSERT INTO game_platforms (game_id, platform_id) VALUES(6, 2);
INSERT INTO game_platforms (game_id, platform_id) VALUES(7, 2);
INSERT INTO game_platforms (game_id, platform_id) VALUES(8, 2);
INSERT INTO game_platforms (game_id, platform_id) VALUES(4, 1);
INSERT INTO game_platforms (game_id, platform_id) VALUES(5, 1);
INSERT INTO game_platforms (game_id, platform_id) VALUES(6, 1);
INSERT INTO game_platforms (game_id, platform_id) VALUES(7, 1);
INSERT INTO game_platforms (game_id, platform_id) VALUES(8, 1);

INSERT INTO game_retailer (game_id, retailer_id) VALUES(1, 2);
INSERT INTO game_retailer (game_id, retailer_id) VALUES(2, 2);
INSERT INTO game_retailer (game_id, retailer_id) VALUES(3, 2);
INSERT INTO game_retailer (game_id, retailer_id) VALUES(4, 2);
INSERT INTO game_retailer (game_id, retailer_id) VALUES(5, 2);
INSERT INTO game_retailer (game_id, retailer_id) VALUES(6, 2);
INSERT INTO game_retailer (game_id, retailer_id) VALUES(7, 4);
INSERT INTO game_retailer (game_id, retailer_id) VALUES(8, 2);



