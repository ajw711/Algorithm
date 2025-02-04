select CAR_TYPE, count(CAR_TYPE) as cars from car_rental_company_car 
where OPTIONS like '%통풍시트%' or  OPTIONS like '%열선시트%' or OPTIONS like '%가죽시트%'
group by car_type
order by car_type;