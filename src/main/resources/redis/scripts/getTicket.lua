local processId = KEYS[1];
local ticketsNums = KEYS[2];
local tickets = KEYS[3];
local ans = 0;
local arr={};
if tonumber(ticketsNums) > 0 then
    for w in string.gmatch(tickets, "%S+") do
        table.insert(arr, w);
        ans = redis.call('SISMEMBER', 'set:seatArrangement:'.. processId, '"'..w..'"');
        if ans==0 then
            return '"'..w..'"';
        end
    end
    for i, ticket in ipairs(arr) do
        ans = redis.call('SREM', 'set:seatArrangement:' .. processId, '"'..ticket..'"');
        if ans==0 then
            return '1'
        end
    end
    return "0"
end
return "3"

