-- 코드를 작성해주세요
select ed.id, ed.genotype, sub.genotype as parent_genotype
  from ecoli_data ed
  inner join ecoli_data sub
    on ed.parent_id = sub.id
    and ed.genotype & sub.genotype = sub.genotype
  order by ed.id;
  