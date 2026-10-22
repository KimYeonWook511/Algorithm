select category, sum(sales) as total_sales
  from book as b
  join book_sales as s
    on b.book_id = s.book_id
  where date_format(sales_date, "%Y-%m") = "2022-01"
  group by category
  order by category;