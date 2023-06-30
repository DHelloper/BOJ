-- 코드를 입력하세요
# SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(CAR_ID) AS RECORDS
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# GROUP BY MONTH, CAR_ID
# HAVING COUNT(CAR_ID) > 4
# ORDER BY MONTH, CAR_ID DESC

SELECT MONTH(START_DATE) AS MONTH, R.CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY R
WHERE R.CAR_ID IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY CAR_ID
    HAVING COUNT(*) >= 5
)
AND R.START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
GROUP BY MONTH(START_DATE), R.CAR_ID
HAVING COUNT(*) > 0
ORDER BY MONTH(START_DATE), R.CAR_ID DESC;