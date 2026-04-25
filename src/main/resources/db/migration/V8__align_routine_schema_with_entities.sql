ALTER TABLE routine_group
    CHANGE COLUMN caution subtitle VARCHAR(100) NULL,
    ADD COLUMN skin_type VARCHAR(100) NOT NULL AFTER skin_result_id;

ALTER TABLE routine_product
    DROP INDEX uk_routine_sort_order,
    DROP COLUMN sort_order,
    ADD COLUMN routine_step_category VARCHAR(50) NOT NULL AFTER product_id,
    ADD UNIQUE KEY uk_routine_step_category (routine_id, routine_step_category);
