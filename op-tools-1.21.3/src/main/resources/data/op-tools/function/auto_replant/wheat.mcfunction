execute if entity @s[nbt={Inventory:[{id:"minecraft:wheat_seeds"}]}] run summon marker ~ ~ ~ {Tags:["wheat"]}
execute if entity @s[nbt={Inventory:[{id:"minecraft:wheat_seeds"}]}] run clear @s wheat_seeds 1
