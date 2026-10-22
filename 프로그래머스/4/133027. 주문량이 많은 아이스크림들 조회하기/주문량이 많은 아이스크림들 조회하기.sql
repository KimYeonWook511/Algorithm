select j.flavor
  from july as j
  left join first_half as f
    on j.shipment_id = f.shipment_id
  group by j.flavor
  order by sum(j.total_order) + f.total_order desc
  limit 3;
  