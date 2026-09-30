select animal_type, count(*)
  from animal_ins
  group by animal_type
  order by case animal_type
             when 'Cat' then 1
             when 'Dog' then 2
           end;