-- 코드를 입력하세요
SELECT book_id, AUTHOR_NAME, date_format(published_date, "%Y-%m-%d") as PUBLISHED_DATE
  from book
left join author
  on book.author_id = author.author_id
  where category like "경제"
  order by 3;