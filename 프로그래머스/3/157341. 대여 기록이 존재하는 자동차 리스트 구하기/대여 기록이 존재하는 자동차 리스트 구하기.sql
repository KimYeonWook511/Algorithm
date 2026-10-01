select c.car_id
  from car_rental_company_car as c
  join car_rental_company_rental_history as h
    on c.car_id = h.car_id
  where c.car_type = "세단"
    and month(start_date) = 10
  group by c.car_id
  order by c.car_id desc;