with MY_TMP as (
    select fi.id, fish_name, length, rank() over(partition by fi.fish_type order by length desc) as rnk
      from fish_info as fi
      join fish_name_info as fni
        on fi.fish_type = fni.fish_type
)

select id, fish_name, length
  from MY_TMP
  where rnk = 1
  order by id;