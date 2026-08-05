#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define TABLE_SIZE 10
#define MAX_STRING_LENGTH 256

unsigned int simple_hash(const char *str) {
    unsigned int hash = 0;
    for (size_t i = 0; i < strlen(str); i++) {
        hash += (unsigned char)str[i];
    }
    return hash % TABLE_SIZE;
}

int main(void) {
    char table[TABLE_SIZE][MAX_STRING_LENGTH];
    bool occupied[TABLE_SIZE] = { false };
    char input[MAX_STRING_LENGTH];
    int choice;

    while (1) {
        printf("\nHash Table Menu:\n");
        printf("1. Insert string\n");
        printf("2. Display table\n");
        printf("3. Exit\n");
        printf("Enter your choice: ");

        if (scanf("%d", &choice) != 1) {
            printf("Invalid input. Please enter a number.\n");
            while (getchar() != '\n');
            continue;
        }
        while (getchar() != '\n');

        if (choice == 1) {
            printf("Enter a string to insert: ");
            if (fgets(input, sizeof(input), stdin) == NULL) {
                printf("Error reading input.\n");
                continue;
            }
            input[strcspn(input, "\n")] = '\0';

            if (input[0] == '\0') {
                printf("No string entered. Try again.\n");
                continue;
            }

            unsigned int index = simple_hash(input);
            if (!occupied[index]) {
                strcpy(table[index], input);
                occupied[index] = true;
                printf("Inserted '%s' at position %u.\n", input, index);
            } else {
                printf("Collision at index %u. Slot already contains '%s'.\n", index, table[index]);
                printf("Insertion failed for '%s'.\n", input);
            }
        } else if (choice == 2) {
            printf("\nHash table contents:\n");
            for (unsigned int i = 0; i < TABLE_SIZE; i++) {
                if (occupied[i]) {
                    printf("%u: %s\n", i, table[i]);
                } else {
                    printf("%u: <empty>\n", i);
                }
            }
        } else if (choice == 3) {
            printf("Exiting...\n");
            break;
        } else {
            printf("Invalid choice. Please enter 1, 2, or 3.\n");
        }
    }

    return 0;
}
