SELECT distinct FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from REST_INFO 
where  FAVORITES in (select  max(FAVORITES) from REST_INFO
                                group by food_type)
group by food_type
order by food_type desc;