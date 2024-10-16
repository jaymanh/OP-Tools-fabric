execute at @e[type=marker, tag=oak] run setblock ~ ~ ~ air destroy

execute at @e[type=marker, tag=oak] if block ~ ~1 ~ minecraft:oak_log run summon marker ~ ~1 ~ {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~ ~-1 ~ minecraft:oak_log run summon marker ~ ~-1 ~ {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~1 ~ ~ minecraft:oak_log run summon marker ~1 ~ ~ {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~-1 ~ ~ minecraft:oak_log run summon marker ~-1 ~ ~ {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~ ~ ~1 minecraft:oak_log run summon marker ~ ~ ~1 {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~ ~ ~-1 minecraft:oak_log run summon marker ~ ~ ~-1 {Tags:["oak"]}

execute at @e[type=marker, tag=oak] if block ~1 ~1 ~ minecraft:oak_log run summon marker ~1 ~1 ~ {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~-1 ~1 ~ minecraft:oak_log run summon marker ~-1 ~1 ~ {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~1 ~-1 ~ minecraft:oak_log run summon marker ~1 ~-1 ~ {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~-1 ~-1 ~ minecraft:oak_log run summon marker ~-1 ~-1 ~ {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~1 ~ ~1 minecraft:oak_log run summon marker ~1 ~ ~1 {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~-1 ~ ~1 minecraft:oak_log run summon marker ~-1 ~ ~1 {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~1 ~ ~-1 minecraft:oak_log run summon marker ~1 ~ ~-1 {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~-1 ~ ~-1 minecraft:oak_log run summon marker ~-1 ~ ~-1 {Tags:["oak"]}

execute at @e[type=marker, tag=oak] if block ~1 ~1 ~1 minecraft:oak_log run summon marker ~1 ~1 ~1 {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~-1 ~1 ~1 minecraft:oak_log run summon marker ~-1 ~1 ~1 {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~1 ~1 ~-1 minecraft:oak_log run summon marker ~1 ~1 ~-1 {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~-1 ~1 ~-1 minecraft:oak_log run summon marker ~-1 ~1 ~-1 {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~1 ~-1 ~1 minecraft:oak_log run summon marker ~1 ~-1 ~1 {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~-1 ~-1 ~1 minecraft:oak_log run summon marker ~-1 ~-1 ~1 {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~1 ~-1 ~-1 minecraft:oak_log run summon marker ~1 ~-1 ~-1 {Tags:["oak"]}
execute at @e[type=marker, tag=oak] if block ~-1 ~-1 ~-1 minecraft:oak_log run summon marker ~-1 ~-1 ~-1 {Tags:["oak"]}



execute as @e[type=marker, tag=oak] if block ~ ~ ~ minecraft:air run kill @s

advancement revoke @a only op-tools:tick-wood