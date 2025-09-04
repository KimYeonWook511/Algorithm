-- 코드를 작성해주세요
select count(*) as count
  from ecoli_data
  where (genotype & ((1 << 2) | (1 << 0))) > 0
    and (genotype & (1 << 1)) = 0;