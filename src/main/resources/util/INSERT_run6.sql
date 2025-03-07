use kinoxp;

INSERT INTO Ticket (ticket_type, showidfk, seatidfk) VALUES
                                                                  ('Standard', 1, 1),  -- Ticket for show 1, seat 1 (Standard)
                                                                  ('Standard', 1, 2),  -- Ticket for show 1, seat 2 (Standard)
                                                                  ('VIP', 2, 151),     -- Ticket for show 2, seat 151 (VIP)
                                                                  ('VIP', 2, 152);     -- Ticket for show 2, seat 152 (VIP)




UPDATE booked_seat
SET ticketidfk = (SELECT ticketID FROM Ticket WHERE showidfk = 1 AND seatidfk = 1), status = 'BOOKED'
WHERE showidfk = 1 AND seatidfk = 23;

UPDATE booked_seat
SET ticketidfk = (SELECT ticketID FROM Ticket WHERE showidfk = 1 AND seatidfk = 2), status = 'BOOKED'
WHERE showidfk = 1 AND seatidfk = 24;

UPDATE booked_seat
SET ticketidfk = (SELECT ticketID FROM Ticket WHERE showidfk = 2 AND seatidfk = 151), status = 'BOOKED'
WHERE showidfk = 2 AND seatidfk = 151;

UPDATE booked_seat
SET ticketidfk = (SELECT ticketID FROM Ticket WHERE showidfk = 2 AND seatidfk = 152), status = 'BOOKED'
WHERE showidfk = 2 AND seatidfk = 152;
