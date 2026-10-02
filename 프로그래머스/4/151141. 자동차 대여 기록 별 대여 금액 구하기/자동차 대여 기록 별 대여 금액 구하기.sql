with tmp as (
    select history_id, car_id, timestampdiff(day, start_date, end_date) + 1 as day_count,
            case
                when timestampdiff(day, start_date, end_date) + 1 >= 90 then (select 1 - discount_rate * 0.01 from car_rental_company_discount_plan where duration_type = "90일 이상" and car_type = "트럭")
                when timestampdiff(day, start_date, end_date) + 1 >= 30 then (select 1 - discount_rate * 0.01 from car_rental_company_discount_plan where duration_type = "30일 이상" and car_type = "트럭")
                when timestampdiff(day, start_date, end_date) + 1 >= 7 then (select 1 - discount_rate * 0.01 from car_rental_company_discount_plan where duration_type = "7일 이상" and car_type = "트럭")
                else 1
            end as val
      from car_rental_company_rental_history
)

select t.history_id, (t.day_count * c.daily_fee * t.val) as fee
  from car_rental_company_car as c
  join tmp as t
    on c.car_id = t.car_id
  where c.car_type = "트럭"
  order by fee desc, t.history_id desc;
  