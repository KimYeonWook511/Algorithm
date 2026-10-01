select i.item_id, item_name
  from item_info as i
  join item_tree as t
    on i.item_id = t.item_id
  where parent_item_id is null
  order by i.item_id;