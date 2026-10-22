select e1.id, e1.genotype, e2.genotype
  from ecoli_data as e1
  join ecoli_data as e2
    on e1.parent_id = e2.id
  where e1.genotype & e2.genotype = e2.genotype
  order by e1.id;