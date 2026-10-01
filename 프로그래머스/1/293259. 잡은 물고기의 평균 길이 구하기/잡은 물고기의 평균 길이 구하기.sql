select round(avg(if(length < 10 or length is null, 10, length)), 2) as average_length
  from fish_info;