select category, sum(sales) as TOTAL_SALES
  from book
  join book_sales as bs
    on book.book_id = bs.book_id
  where date_format(sales_date, "%Y-%m") = "2022-01"
  group by category
  order by category;