select b.author_id, author_name, category, (sum(sales * price)) as TOTAL_SALES
  from book as b
  join author as a
    on b.author_id = a.author_id
  join book_sales as bs
    on b.book_id = bs.book_id
  where date_format(sales_date, "%Y-%m") = "2022-01"
  group by a.author_id, category
  order by b.author_id, category desc;