package org.example;

interface Computer{
    void code();
}

class Laptop implements Computer{
    public void code(){
        System.out.println("Coding in Laptop");
    }
}

class Desktop implements  Computer{
    public void code(){
        System.out.println("Coding in Desktop");
    }
}
class Cpu{
    public void cpu(){
        System.out.println("Checking CPU percentage");
    }
}

class Developer extends Cpu{
    public Developer(){
        cpu();
        System.out.println("Finished CPU checking from constructor");
    }
    public void devApp(Computer comp){
        comp.code();
    }
}
public class Demo1 {
    public static void main(String[] args) {
        Computer lap = new Laptop();
        Computer desk = new Desktop();

        Cpu dev = new Developer();
        dev.cpu();

        Developer dev1 = (Developer) dev;
        dev1.devApp(desk);
        
        // Demonstrate Streams work with many types
        demonstrateStreams();
        
        // Demonstrate efficient HashMap initialization
        demonstrateEfficientMapInitialization();
        
        // Demonstrate finding max value in map
        demonstrateMaxValueInMap();
    }
    
    public static void demonstrateStreams(){
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║          DOES Stream WORK ONLY WITH Lists?                 ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
        
        System.out.println("ANSWER: NO! Streams work with MANY types, not just Lists!\n");
        
        // Example 1: List - WORKS ✅
        System.out.println("=== EXAMPLE 1: List (WORKS) ✅ ===");
        java.util.List<String> list = java.util.Arrays.asList("Sathya", "Jaanu", "Padmini");
        long count1 = list.stream().filter(s -> s.length() > 5).count();
        System.out.println("List: " + list);
        System.out.println("list.stream().filter(...).count(): " + count1);
        System.out.println("✅ Works!\n");
        
        // Example 2: Set - WORKS ✅
        System.out.println("=== EXAMPLE 2: Set (WORKS) ✅ ===");
        java.util.Set<String> set = new java.util.HashSet<>(java.util.Arrays.asList("Sathya", "Jaanu", "Padmini"));
        long count2 = set.stream().map(String::toUpperCase).count();
        System.out.println("Set: " + set);
        System.out.println("set.stream().map(...).count(): " + count2);
        System.out.println("✅ Works!\n");
        
        // Example 3: Map - WORKS ✅ (different methods)
        System.out.println("=== EXAMPLE 3: Map (WORKS) ✅ ===");
        java.util.Map<String, Integer> map = new java.util.HashMap<>();
        map.put("Sathya", 25);
        map.put("Jaanu", 30);
        map.put("Padmini", 28);
        System.out.println("Map: " + map);
        System.out.println("Keys stream:");
        map.keySet().stream().forEach(System.out::println);
        System.out.println("Values stream:");
        map.values().stream().forEach(System.out::println);
        System.out.println("Entries stream:");
        map.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));
        System.out.println("✅ Works with keySet(), values(), entrySet()!\n");
        
        // Example 4: Array - WORKS ✅
        System.out.println("=== EXAMPLE 4: Array (WORKS) ✅ ===");
        String[] array = {"Sathya", "Jaanu", "Padmini"};
        System.out.println("Array: " + java.util.Arrays.toString(array));
        long count3 = java.util.Arrays.stream(array).count();
        System.out.println("Arrays.stream(array).count(): " + count3);
        System.out.println("✅ Works with Arrays.stream()!\n");
        
        // Example 5: Queue - WORKS ✅
        System.out.println("=== EXAMPLE 5: Queue (WORKS) ✅ ===");
        java.util.Queue<String> queue = new java.util.LinkedList<>(java.util.Arrays.asList("Sathya", "Jaanu", "Padmini"));
        System.out.println("Queue: " + queue);
        queue.stream().forEach(s -> System.out.println("  - " + s));
        System.out.println("✅ Works!\n");
        
        // Example 6: Collection interface - WORKS ✅
        System.out.println("=== EXAMPLE 6: Collection (WORKS) ✅ ===");
        java.util.Collection<Integer> collection = new java.util.ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4, 5));
        int sum = collection.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Collection: " + collection);
        System.out.println("collection.stream().mapToInt(...).sum(): " + sum);
        System.out.println("✅ Works!\n");
        
        // Example 7: Direct Stream creation - WORKS ✅
        System.out.println("=== EXAMPLE 7: Direct Stream Creation (WORKS) ✅ ===");
        java.util.stream.Stream<String> directStream = java.util.stream.Stream.of("Sathya", "Jaanu", "Padmini");
        System.out.println("Stream.of(\"Sathya\", \"Jaanu\", \"Padmini\")");
        directStream.forEach(s -> System.out.println("  - " + s));
        System.out.println("✅ Works!\n");
        
        // Example 8: IntStream, LongStream, DoubleStream
        System.out.println("=== EXAMPLE 8: Primitive Streams (WORKS) ✅ ===");
        System.out.println("IntStream.range(1, 5).sum(): " + 
            java.util.stream.IntStream.range(1, 5).sum());
        System.out.println("LongStream.range(1, 5).sum(): " + 
            java.util.stream.LongStream.range(1, 5).sum());
        System.out.println("DoubleStream.of(1.1, 2.2, 3.3).sum(): " + 
            java.util.stream.DoubleStream.of(1.1, 2.2, 3.3).sum());
        System.out.println("✅ Works with primitive streams!\n");
        
        // Summary
        System.out.println("=== SUMMARY ===");
        System.out.println("Streams work with:");
        System.out.println("  ✅ List (ArrayList, LinkedList, Vector, etc.)");
        System.out.println("  ✅ Set (HashSet, TreeSet, LinkedHashSet)");
        System.out.println("  ✅ Map (via keySet(), values(), entrySet())");
        System.out.println("  ✅ Queue (PriorityQueue, LinkedList, etc.)");
        System.out.println("  ✅ Collection interface (any Collection type)");
        System.out.println("  ✅ Arrays (using Arrays.stream())");
        System.out.println("  ✅ Direct creation (Stream.of(), IntStream.range(), etc.)");
        
        System.out.println("\n📚 KEY METHODS TO CREATE STREAMS:");
        System.out.println("  1. collection.stream()         - From any Collection");
        System.out.println("  2. Arrays.stream(array)        - From arrays");
        System.out.println("  3. Stream.of(values...)       - Direct creation");
        System.out.println("  4. IntStream.range(start, end) - Primitive streams");
        System.out.println("  5. map.keySet().stream()      - From Map keys");
        System.out.println("  6. map.values().stream()      - From Map values");
        System.out.println("  7. map.entrySet().stream()    - From Map entries");
        
        System.out.println("\n💡 DIFFERENCE from Collections.sort():");
        System.out.println("  • Collections.sort() → ONLY works with List");
        System.out.println("  • Streams → Work with ANY Collection type + Arrays + more!");
        System.out.println("  • Streams are more flexible and powerful");
    }
    
    public static void demonstrateEfficientMapInitialization(){
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║        EFFICIENT HASHMAP INITIALIZATION                     ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
        
        System.out.println("=== ORIGINAL CODE (Verbose) ===");
        System.out.println("Map<String,Integer> map = new HashMap<>();");
        System.out.println("map.put(\"AB\",90);");
        System.out.println("map.put(\"CD\",50);");
        System.out.println("map.put(\"EF\",79);");
        System.out.println("map.put(\"GH\",81);");
        System.out.println("map.put(\"IJ\",87);\n");
        
        // Option 1: Map.of() - Java 9+ (IMMUTABLE)
        System.out.println("=== OPTION 1: Map.of() (Java 9+) - IMMUTABLE ===");
        System.out.println("Map<String,Integer> map = Map.of(");
        System.out.println("    \"AB\", 90,");
        System.out.println("    \"CD\", 50,");
        System.out.println("    \"EF\", 79,");
        System.out.println("    \"GH\", 81,");
        System.out.println("    \"IJ\", 87");
        System.out.println(");");
        System.out.println("⚠️ Note: Creates IMMUTABLE map (cannot add/modify after creation)\n");
        
        // Option 2: Map.ofEntries() with new HashMap<>() - Java 9+ (MUTABLE)
        System.out.println("=== OPTION 2: Map.ofEntries() + new HashMap<>() (Java 9+) - MUTABLE ===");
        System.out.println("Map<String,Integer> map = new HashMap<>(Map.ofEntries(");
        System.out.println("    Map.entry(\"AB\", 90),");
        System.out.println("    Map.entry(\"CD\", 50),");
        System.out.println("    Map.entry(\"EF\", 79),");
        System.out.println("    Map.entry(\"GH\", 81),");
        System.out.println("    Map.entry(\"IJ\", 87)");
        System.out.println("));");
        System.out.println("✅ Creates MUTABLE HashMap\n");
        
        java.util.Map<String,Integer> map2 = new java.util.HashMap<>(java.util.Map.ofEntries(
            java.util.Map.entry("AB", 90),
            java.util.Map.entry("CD", 50),
            java.util.Map.entry("EF", 79),
            java.util.Map.entry("GH", 81),
            java.util.Map.entry("IJ", 87)
        ));
        System.out.println("Result: " + map2);
        System.out.println("✅ Can modify: map2.put(\"KL\", 95) works!\n");
        
        // Option 3: Stream with Collectors.toMap() - Java 8+ (MUTABLE)
        System.out.println("=== OPTION 3: Stream.of() + Collectors.toMap() (Java 8+) - MUTABLE ===");
        System.out.println("Map<String,Integer> map = Stream.of(");
        System.out.println("    new Object[][]{");
        System.out.println("        {\"AB\", 90},");
        System.out.println("        {\"CD\", 50},");
        System.out.println("        {\"EF\", 79},");
        System.out.println("        {\"GH\", 81},");
        System.out.println("        {\"IJ\", 87}");
        System.out.println("    })");
        System.out.println("    .collect(Collectors.toMap(data -> (String)data[0], data -> (Integer)data[1]));");
        System.out.println("✅ Creates MUTABLE HashMap\n");
        
        // Option 4: Double brace initialization (NOT RECOMMENDED)
        System.out.println("=== OPTION 4: Double Brace Initialization (NOT RECOMMENDED) ===");
        System.out.println("Map<String,Integer> map = new HashMap<String,Integer>() {{");
        System.out.println("    put(\"AB\", 90);");
        System.out.println("    put(\"CD\", 50);");
        System.out.println("    put(\"EF\", 79);");
        System.out.println("    put(\"GH\", 81);");
        System.out.println("    put(\"IJ\", 87);");
        System.out.println("}};");
        System.out.println("❌ Creates anonymous class, memory overhead, not recommended\n");
        
        // Option 5: Using a helper method
        System.out.println("=== OPTION 5: Helper Method (Reusable) ===");
        System.out.println("private static <K, V> Map<K, V> mapOf(Object... entries) {");
        System.out.println("    Map<K, V> map = new HashMap<>();");
        System.out.println("    for (int i = 0; i < entries.length; i += 2) {");
        System.out.println("        map.put((K) entries[i], (V) entries[i + 1]);");
        System.out.println("    }");
        System.out.println("    return map;");
        System.out.println("}");
        System.out.println("Map<String,Integer> map = mapOf(");
        System.out.println("    \"AB\", 90, \"CD\", 50, \"EF\", 79, \"GH\", 81, \"IJ\", 87");
        System.out.println(");\n");
        
        // Best practice recommendation
        System.out.println("=== RECOMMENDED APPROACH ===");
        System.out.println("For MUTABLE HashMap (most common use case):");
        System.out.println("  ✅ Use Option 2: new HashMap<>(Map.ofEntries(...))");
        System.out.println("     - Clean, readable, one line");
        System.out.println("     - Mutable (can add/modify entries)");
        System.out.println("     - Java 9+\n");
        
        System.out.println("For IMMUTABLE map:");
        System.out.println("  ✅ Use Option 1: Map.of(...)");
        System.out.println("     - Simplest, most efficient");
        System.out.println("     - Immutable (thread-safe, cannot modify)");
        System.out.println("     - Java 9+\n");
        
        System.out.println("For Java 8 compatibility:");
        System.out.println("  ✅ Use Option 3: Stream + Collectors.toMap()");
        System.out.println("     - Works with Java 8+");
        System.out.println("     - Mutable HashMap\n");
        
        // Practical example
        System.out.println("=== PRACTICAL EXAMPLE ===");
        System.out.println("// Your original code (5 lines):");
        System.out.println("Map<String,Integer> map = new HashMap<>();");
        System.out.println("map.put(\"AB\",90);");
        System.out.println("map.put(\"CD\",50);");
        System.out.println("map.put(\"EF\",79);");
        System.out.println("map.put(\"GH\",81);");
        System.out.println("map.put(\"IJ\",87);\n");
        
        System.out.println("// Refactored (1 line):");
        System.out.println("Map<String,Integer> map = new HashMap<>(Map.ofEntries(");
        System.out.println("    Map.entry(\"AB\", 90), Map.entry(\"CD\", 50),");
        System.out.println("    Map.entry(\"EF\", 79), Map.entry(\"GH\", 81), Map.entry(\"IJ\", 87)");
        System.out.println("));");
    }
    
    public static void demonstrateMaxValueInMap(){
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║        FINDING MAX VALUE IN MAP                               ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
        
        // Create sample map
        java.util.Map<String,Integer> map = new java.util.HashMap<>(java.util.Map.ofEntries(
            java.util.Map.entry("AB", 90),
            java.util.Map.entry("CD", 50),
            java.util.Map.entry("EF", 79),
            java.util.Map.entry("GH", 81),
            java.util.Map.entry("IJ", 87)
        ));
        
        System.out.println("Sample Map: " + map);
        System.out.println("Expected max value: 90\n");
        
        System.out.println("=== YOUR QUESTION: reduce() Arguments ===");
        System.out.println("You asked: int s1 = map.values().stream().sorted().reduce();");
        System.out.println("What are the reduce() arguments?\n");
        
        System.out.println("=== REDUCE() METHOD SIGNATURES ===");
        System.out.println("1. Optional<T> reduce(BinaryOperator<T> accumulator)");
        System.out.println("   - Takes a BinaryOperator (function that combines two values)");
        System.out.println("   - Returns Optional<T>\n");
        
        System.out.println("2. T reduce(T identity, BinaryOperator<T> accumulator)");
        System.out.println("   - Takes initial value (identity) and BinaryOperator");
        System.out.println("   - Returns T (not Optional)\n");
        
        System.out.println("3. <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)");
        System.out.println("   - For parallel streams (more complex)\n");
        
        // Method 1: Using max() - BEST APPROACH
        System.out.println("=== METHOD 1: Using max() - RECOMMENDED ✅ ===");
        System.out.println("Optional<Integer> max = map.values().stream().max(Integer::compare);");
        System.out.println("int maxValue = max.orElse(0);");
        
        java.util.Optional<Integer> max1 = map.values().stream().max(Integer::compare);
        int maxValue1 = max1.orElse(0);
        System.out.println("Result: " + maxValue1);
        System.out.println("✅ Most efficient - no sorting needed!\n");
        
        // Method 2: Using reduce() with BinaryOperator
        System.out.println("=== METHOD 2: Using reduce() with BinaryOperator ===");
        System.out.println("Optional<Integer> max = map.values().stream()");
        System.out.println("    .reduce((a, b) -> a > b ? a : b);");
        System.out.println("// OR using Math.max:");
        System.out.println("Optional<Integer> max = map.values().stream()");
        System.out.println("    .reduce(Integer::max);");
        
        java.util.Optional<Integer> max2 = map.values().stream()
            .reduce(Integer::max);
        System.out.println("Result: " + max2.orElse(0));
        System.out.println("✅ Efficient - no sorting needed!\n");
        
        // Method 3: Using reduce() with identity (returns int, not Optional)
        System.out.println("=== METHOD 3: Using reduce() with Identity ===");
        System.out.println("int max = map.values().stream()");
        System.out.println("    .reduce(Integer.MIN_VALUE, Integer::max);");
        System.out.println("// Identity = starting value (Integer.MIN_VALUE = smallest int)");
        
        int max3 = map.values().stream()
            .reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("Result: " + max3);
        System.out.println("✅ Returns int directly (not Optional)\n");
        
        // Method 4: Using sorted() + reduce() - NOT EFFICIENT
        System.out.println("=== METHOD 4: Using sorted() + reduce() - NOT RECOMMENDED ❌ ===");
        System.out.println("Your approach: map.values().stream().sorted().reduce(...)");
        System.out.println("Problem: Sorting is unnecessary overhead!");
        System.out.println("Better: Use max() or reduce() directly without sorting\n");
        
        System.out.println("If you still want to use sorted().reduce():");
        System.out.println("Optional<Integer> max = map.values().stream()");
        System.out.println("    .sorted()                    // Sorts ascending");
        System.out.println("    .reduce((first, second) -> second);  // Gets last element");
        System.out.println("// OR get first element after reverse sort:");
        System.out.println("Optional<Integer> max = map.values().stream()");
        System.out.println("    .sorted(Collections.reverseOrder())");
        System.out.println("    .findFirst();\n");
        
        // Method 5: Using mapToInt() for primitive int
        System.out.println("=== METHOD 5: Using mapToInt() - For Primitive int ===");
        System.out.println("OptionalInt max = map.values().stream()");
        System.out.println("    .mapToInt(Integer::intValue)");
        System.out.println("    .max();");
        System.out.println("int maxValue = max.orElse(0);");
        
        java.util.OptionalInt max4 = map.values().stream()
            .mapToInt(Integer::intValue)
            .max();
        System.out.println("Result: " + max4.orElse(0));
        System.out.println("✅ Best for primitive int operations\n");
        
        // Complete examples with reduce() arguments
        System.out.println("=== COMPLETE REDUCE() EXAMPLES ===");
        System.out.println("// Example 1: reduce(BinaryOperator) - Returns Optional");
        System.out.println("Optional<Integer> max = map.values().stream()");
        System.out.println("    .reduce((a, b) -> a > b ? a : b);");
        System.out.println("// BinaryOperator: (a, b) -> a > b ? a : b");
        System.out.println("// OR: Integer::max\n");
        
        System.out.println("// Example 2: reduce(identity, BinaryOperator) - Returns int");
        System.out.println("int max = map.values().stream()");
        System.out.println("    .reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);");
        System.out.println("// Identity: Integer.MIN_VALUE (starting value)");
        System.out.println("// BinaryOperator: (a, b) -> a > b ? a : b");
        System.out.println("// OR: .reduce(Integer.MIN_VALUE, Integer::max);\n");
        
        // Practical comparison
        System.out.println("=== PRACTICAL COMPARISON ===");
        System.out.println("Your approach (with sorted):");
        System.out.println("  ❌ O(n log n) - sorting overhead");
        System.out.println("  ❌ Unnecessary - sorting not needed for max");
        System.out.println("  ✅ Works but inefficient\n");
        
        System.out.println("Better approaches:");
        System.out.println("  ✅ max() - O(n), clean, readable");
        System.out.println("  ✅ reduce(Integer::max) - O(n), functional style");
        System.out.println("  ✅ mapToInt().max() - O(n), best for primitives\n");
        
        // Answer to specific question
        System.out.println("=== ANSWER TO YOUR QUESTION ===");
        System.out.println("For: int s1 = map.values().stream().sorted().reduce(...);");
        System.out.println("\nOption 1 (with Optional):");
        System.out.println("Optional<Integer> max = map.values().stream()");
        System.out.println("    .sorted()");
        System.out.println("    .reduce((a, b) -> b);  // Gets last element after sort");
        System.out.println("int s1 = max.orElse(0);\n");
        
        System.out.println("Option 2 (with identity):");
        System.out.println("int s1 = map.values().stream()");
        System.out.println("    .sorted()");
        System.out.println("    .reduce(Integer.MIN_VALUE, (a, b) -> b);\n");
        
        System.out.println("⚠️ BUT: Don't use sorted() for finding max!");
        System.out.println("✅ Instead use:");
        System.out.println("int s1 = map.values().stream()");
        System.out.println("    .reduce(Integer.MIN_VALUE, Integer::max);");
        System.out.println("// OR:");
        System.out.println("int s1 = map.values().stream()");
        System.out.println("    .max(Integer::compare).orElse(0);");
    }
}
