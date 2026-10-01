select c.car_id, c.car_type, 30 * daily_fee * (1 - discount_rate * 0.01) as fee
  from car_rental_company_car as c
  join car_rental_company_discount_plan as d
    on c.car_type = d.car_type
  where (c.car_type = "세단" or c.car_type = "SUV")
    and c.car_id not in (select car_id
                         from car_rental_company_rental_history
                         where end_date >= "2022-11-01"
                           and start_date <= "2022-11-30")
    and duration_type = "30일 이상" 
    and (500000 <= 30 * daily_fee * (1 - discount_rate * 0.01))
    and (30 * daily_fee * (1 - discount_rate * 0.01) < 2000000)
  order by fee desc, c.car_type, c.car_id desc;