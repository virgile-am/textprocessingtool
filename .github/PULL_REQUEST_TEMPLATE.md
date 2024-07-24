# Pull Request Template

## Description
Please include a summary of the change and which issue is fixed. Also include relevant motivation and context.

Fixes # (issue)

## Type of change
Please delete options that are not relevant.

- [ ] Bug fix (non-breaking change which fixes an issue)
- [ ] New feature (non-breaking change which adds functionality)
- [ ] Breaking change (fix or feature that would cause existing functionality to not work as expected)
- [ ] This change requires a documentation update

## How Has This Been Tested?
Please describe the tests that you ran to verify your changes. Provide instructions so we can reproduce. Please also list any relevant details for your test configuration.

- [ ] Test A
- [ ] Test B

## Checklist:
Before submitting your PR, please review the following checklist:

### General
- [ ] My code follows the style guidelines of AmaliTech
- [ ] I have performed a self-review of my own code
- [ ] I have commented my code, particularly in hard-to-understand areas
- [ ] I have made corresponding changes to the documentation
- [ ] My changes generate no new warnings
- [ ] I have added tests that prove my fix is effective or that my feature works
- [ ] New and existing unit tests pass locally with my changes
- [ ] Any dependent changes have been merged and published in downstream modules

### Clean Code Principles
- [ ] Functions are small and do one thing
- [ ] Variable names are descriptive and unambiguous
- [ ] Code is properly formatted with correct indentation
- [ ] No magic numbers or string literals (replaced with named constants)
- [ ] Error handling is implemented correctly
- [ ] No unnecessary comments (code is self-explanatory where possible)
- [ ] SOLID principles are followed

### Testing
- [ ] Tests are clean, readable, and independent
- [ ] Test coverage is 100% (all statements and branches)
- [ ] Each test focuses on a single concept

### Concurrency (if applicable)
- [ ] Asynchronous operations use async/await instead of callbacks or raw promises

### SOLID Principles
- [ ] Single Responsibility Principle: Each class has only one reason to change
- [ ] Open/Closed Principle: Classes are open for extension but closed for modification
- [ ] Liskov Substitution Principle: Derived classes are substitutable for their base classes
- [ ] Interface Segregation Principle: No client is forced to depend on methods it does not use
- [ ] Dependency Inversion Principle: High-level modules do not depend on low-level modules, both depend on abstractions

## Additional Notes
Add any other context or screenshots about the pull request here.