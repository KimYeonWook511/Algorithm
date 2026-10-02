select *, if(timestampdiff(day, start_date, end_date) + 1 >= 30, "장기 대여", "단기 대여") as rent_type
  from car_rental_company_rental_history as h
  where date_format(start_date, "%Y-%m") = "2022-09"
  order by history_id desc;