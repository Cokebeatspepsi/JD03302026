-- Select
Select id
from accounts; -- Selects id column from accounts

-- Where
 Select last_name
 From customers
 Where last_name = 'Patel'; -- Selects the last name from customer with the matching last name
 
-- Order By
Select created_at
From  audit_logs
Order by created_at; -- orders the audit logs by the time they were created

-- And
Select id, customer_id 
From Accounts
Where Balance >= '3000' AND Type = 'CHECKING'; -- selects the id and customer_id from accounts where the ending checking balance is greater than 3000 

-- Or
Select message
From notifications
Where  type = 'ALERT' or type = 'SECURITY'; -- selects the message from notifications where the type is ALERT or SECURITY

-- Not
Select account_number
From accounts
Where Not status = 'ACTIVE' Or status = 'Frozen'; -- selects the account number from accounts where the status of the account is not active but is frozen

-- Insert Into
-- Insert Into customers(id, email, first_name,last_name, created_at )
-- Values( 11,'kmnkansah@gmail.com','Kwaku','Nkansah','2026-04-3 11:18:00');

Select id, email, first_name, last_name, created_at -- check for insert
From customers
Where first_name = 'Kwaku';

-- Update
Update customers
Set id = 13 , email = 'kwakukansah@gmail.com' 
Where id = 12 and email = 'kmnkansah@gmail.com';








