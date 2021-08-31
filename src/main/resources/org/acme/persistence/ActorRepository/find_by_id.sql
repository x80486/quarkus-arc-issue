--
-- Find actor by identifier
--
select
  id,
  first_name,
  last_name,
  updated_at
from actors
where id = :id
