select animal_type, if (name is null, "No name", name), sex_upon_intake
  from animal_ins
  order by animal_id;
  