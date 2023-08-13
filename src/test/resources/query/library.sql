select isbn,b.name,author,bc.name,year
from books b join book_categories bc on b.book_category_id = bc.id
where  b.name = 'Clean Code';

select * from book_borrow;

select * from book_categories;

select * from books;


select *
from user_groups;

select * from book_borrow;

select bc.name
from book_categories bc join books b on bc.id = b.book_category_id
join book_borrow bb on b.id = bb.book_id
group by bc.name
order by count(*) desc
LIMIT 1;


select b.name, isbn,year, author,bc.name
from books b join book_categories bc on bc.id = b.book_category_id
where b.name = 'Head First Java V2.0';

