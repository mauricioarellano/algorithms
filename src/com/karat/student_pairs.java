/*
def find_pairs(student_course)
  result = {}
  pairs = []
  student_course_dup = student_course.dup
  
  student_course.each do |item| ## n*n
    student_id = item.first
    course = item.last
    student_course_dup.each do |element|
      next if element.first == student_id
      pair = [student_id, element.first].sort
      pairs << pair unless pairs.include? pair
    end
  end
  
 # puts "pairs: #{pairs}"
  
  pairs.each do |pair| ## s - 2
    student1 = pair.first
    student2 = pair.last
    student1_courses = student_course.select {|item| item.first == student1 }.map{|item| item.last}
    
    student2_courses = student_course.select {|item| item.first == student2 }.map{|item| item.last}
    
  #  puts "student1_courses: #{student1_courses}\n student2_courses: #{student2_courses}"
    
    common_courses = student1_courses & student2_courses
    
    result[pair] = common_courses
    
  end
  
  result  ## O( n*n + s)
          ## S(2n)
  
end



student_course_pairs_1 = [
  ["58", "Linear Algebra"],
  ["94", "Art History"],
  ["94", "Operating Systems"],
  ["17", "Software Design"],
  ["58", "Mechanics"],
  ["58", "Economics"],
  ["17", "Linear Algebra"],
  ["17", "Political Science"],
  ["94", "Economics"],
  ["25", "Economics"],
  ["58", "Software Design"],
]

puts find_pairs(student_course_pairs_1)

student_course_pairs_2 = [
  ["0", "Advanced Mechanics"],
  ["0", "Art History"],
  ["1", "Course 1"],
  ["1", "Course 2"],
  ["2", "Computer Architecture"],
  ["3", "Course 1"],
  ["3", "Course 2"],
  ["4", "Algorithms"],
]

puts find_pairs(student_course_pairs_2)

student_course_pairs_3 = [
  ["23", "Software Design"], 
  ["3",  "Advanced Mechanics"], 
  ["2",  "Art History"], 
  ["33", "Another"],
]

puts find_pairs(student_course_pairs_3)

*/
