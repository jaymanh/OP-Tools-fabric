execute at @e[type=marker,tag=carrot] run setblock ~ ~ ~ carrots
execute at @e[type=marker,tag=potato] run setblock ~ ~ ~ potatoes
execute at @e[type=marker,tag=beetroot] run setblock ~ ~ ~ beetroots
execute at @e[type=marker,tag=wheat] run setblock ~ ~ ~ wheat
execute at @e[type=marker,tag=nether_wart] run setblock ~ ~ ~ nether_wart

kill @e[type=marker,tag=carrot]
kill @e[type=marker,tag=potato]
kill @e[type=marker,tag=beetroot]
kill @e[type=marker,tag=wheat]
kill @e[type=marker,tag=nether_wart]

advancement revoke @a only op-tools:tick-crop