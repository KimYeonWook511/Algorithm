select car_id, round(avg(timestampdiff(day, start_date, end_date) + 1), 1) as average_duration
  from car_rental_company_rental_history
  group by car_id having avg(timestampdiff(day, start_date, end_date) + 1) >= 7
  order by `average_duration` desc, car_id desc;