# Kata 2: ISP -- Printer Interface

| Field | Value |
|-------|-------|
| Concepts | ISP, interface splitting |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

The following `MultiFunctionPrinter` interface violates ISP. Split it into smaller interfaces.

```java
interface MultiFunctionPrinter {
    void print(String document);
    void scan(String document);
    void fax(String document);
    void staple(String document);
}
```

Create these interfaces:
- `Printer` with `print()`
- `Scanner` with `scan()`
- `FaxMachine` with `fax()`
- `Stapler` with `staple()`

Then implement classes:
- `BasicPrinter` implements Printer only
- `AllInOnePrinter` implements all four
- `FaxMachineImpl` implements FaxMachine only

### Example Output

```
BasicPrinter: Printing document...
AllInOnePrinter: Printing document...
AllInOnePrinter: Scanning document...
FaxMachineImpl: Faxing document...
```

### Extension

Add a `Photocopier` that implements both Printer and Scanner.
