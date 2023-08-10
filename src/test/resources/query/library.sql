select isbn,b.name,author,bc.name,year
from books b join book_categories bc on b.book_category_id = bc.id
where  b.name = 'Clean Code';

select * from book_borrow;
