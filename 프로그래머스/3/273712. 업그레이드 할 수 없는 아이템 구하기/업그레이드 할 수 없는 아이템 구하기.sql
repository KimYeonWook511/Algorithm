select i.item_id, item_name, rarity
  from item_info as i
  left join item_tree as t
    on i.item_id = t.parent_item_id
  where t.item_id is null
  order by i.item_id desc;