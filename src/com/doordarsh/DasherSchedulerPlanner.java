/*

You're a dasher, and you want to try planning out your schedule. You can view a list of deliveries along with their associated start time, end time, 
and dollar amount for completing the order. Assuming dashers can only deliver one order at a time, determine the maximum amount of money you can make 
from the given deliveries.

The inputs are as follows:

int start_time: when you plan to start your schedule
int end_time: when you plan to end your schedule
int d_starts[n]: the start times of each delivery[i]
int d_ends[n]: the end times of each delivery[i]
int d_pays[n]: the pay for each delivery[i]
The output should be an integer representing the maximum amount of money you can make by forming a schedule with the given deliveries.

Constraints
end_time >= start_time
d_ends[i] >= d_starts[i]
d_pays[i] > 0
len(d_starts) == len(d_ends) == len(d_pays)

Example
dict(
    start_time = 0,
    end_time = 10,
    d_starts = [2, 3, 5, 7],
    d_ends = [6, 5, 10, 11],
    d_pays = [5, 2, 4, 1],
    expect = 6,
)

*/

/**
# Ruby solution:
 
def max_amount(input)
    max_money = 0
    start_time = input[:start_time]
    end_time = input[:end_time]
    d_starts = input[:d_starts]
    d_ends = input[:d_ends]
    d_pays = input[:d_pays]
    
    for i in 0..(d_starts.length-1) do
        money = 0
        stack = []
        if start_time <= d_starts[i] && end_time >= d_ends[i] && (stack.empty? || stack.first[:d_ends] <= d_starts[i])
            stack << {
                :d_starts => d_starts[i],
                :d_ends => d_ends[i],
                :d_pays => d_pays[i]
            }
            money += d_pays[i]
        end
        #puts "stack status on #{i} iteration: #{stack}"

        for j in 0..(d_starts.length-1) do
            #puts "nested iteration [#{i}][#{j}]: #{stack}"
            if start_time <= d_starts[j] && end_time >= d_ends[j] && (stack.empty? || stack.first[:d_ends] <= d_starts[j])
                stack << {
                    :d_starts => d_starts[j],
                    :d_ends => d_ends[j],
                    :d_pays => d_pays[j]
                }
                money += d_pays[j]
            end    
        end
        
        max_money = money if money > max_money
        
    end
    
    return max_money
end

example1 = {
    :start_time => 0,
    :end_time => 10,
    :d_starts => [2, 3, 5,  7],
    :d_ends =>   [6, 5, 10, 11],
    :d_pays =>   [5, 2, 4,  1]
}

puts max_amount example1 # expects to be 6
*/
