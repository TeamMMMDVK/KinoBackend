use kinoxp;

UPDATE booked_seat 
SET status = 'BOOKED', ticketidfk = 1, reservationidfk = 1 
WHERE seatidfk = 1 AND showidfk = 1;

UPDATE booked_seat 
SET status = 'BOOKED', ticketidfk = 2, reservationidfk = 1 
WHERE seatidfk = 2 AND showidfk = 1;

UPDATE booked_seat 
SET status = 'BOOKED', ticketidfk = 2, reservationidfk = 2 
WHERE seatidfk = 8 AND showidfk = 2;

UPDATE booked_seat 
SET status = 'BOOKED', ticketidfk = 1, reservationidfk = 2 
WHERE seatidfk = 9 AND showidfk = 2;

UPDATE booked_seat 
SET status = 'BOOKED', ticketidfk = 1, reservationidfk = 3 
WHERE seatidfk = 22 AND showidfk = 16;

UPDATE booked_seat 
SET status = 'BOOKED', ticketidfk = 3, reservationidfk = 3 
WHERE seatidfk = 23 AND showidfk = 16;

UPDATE booked_seat 
SET status = 'BOOKED', ticketidfk = 3, reservationidfk = 3 
WHERE seatidfk = 24 AND showidfk = 16;

UPDATE booked_seat 
SET status = 'BOOKED', ticketidfk = 3, reservationidfk = 3 
WHERE seatidfk = 25 AND showidfk = 16;

UPDATE booked_seat 
SET status = 'BOOKED', ticketidfk = 1, reservationidfk = 4 
WHERE seatidfk = 305 AND showidfk = 20;

UPDATE booked_seat 
SET status = 'BOOKED', ticketidfk = 1, reservationidfk = 4 
WHERE seatidfk = 306 AND showidfk = 20;
