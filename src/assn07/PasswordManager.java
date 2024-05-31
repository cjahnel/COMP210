package assn07;

import java.util.*;

public class PasswordManager<K,V> implements Map<K,V> {
    private static final String MASTER_PASSWORD = "password321";
    private Account[] _passwords;

    private int size;

    public PasswordManager() {
        _passwords = new Account[50];
    }

    private int keyToIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % 50;
    }

    @Override
    public void put(K key, V value) {
        int index = keyToIndex(key);
        Account<K, V> current = _passwords[index];

        if (current == null) {
            _passwords[index] = new Account<>(key, value);
            size++;
            return;
        }

        Account<K, V> previous = null;

        while (current != null) {
            if (current.getWebsite().equals(key)) {
                current.setPassword(value);
                return;
            }

            previous = current;
            current = current.getNext();
        }

        Account<K, V> newAccount = new Account<>(key, value);
        previous.setNext(newAccount);
        size++;
    }

    @Override
    public V get(K key) {
        int index = keyToIndex(key);
        Account<K, V> current = _passwords[index];

        while (current != null) {
            if (current.getWebsite().equals(key)) {
                return current.getPassword();
            }
            current = current.getNext();
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<K> keySet() {
        HashSet<K> keySet = new HashSet<>();

        for (Account<K, V> account : _passwords) {
            if (account == null) {
                continue;
            }

            Account<K, V> current = account;

            while (current != null) {
                keySet.add(current.getWebsite());
                current = current.getNext();
            }
        }

        return keySet;
    }

    @Override
    public V remove(K key) {
        int index = keyToIndex(key);
        Account<K, V> current = _passwords[index];
        Account<K, V> previous = null;

        while (current != null) {
            if (current.getWebsite().equals(key)) {  // && hashCode == current.getWebsite().hashCode()) {
                break;
            }

            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            return null;
        }

        if (previous != null) {
            previous.setNext(current.getNext());
        } else {
            _passwords[index] = current.getNext();
        }

        size--;

        return current.getPassword();
    }

    @Override
    public List<K> checkDuplicate(V value) {
        List<K> duplicates = new ArrayList<>();

        for (Account<K, V> account : _passwords) {
            if (account == null) {
                continue;
            }

            Account<K, V> current = account;

            while (current != null) {
                if (current.getPassword().equals(value)) {
                    duplicates.add(current.getWebsite());
                }
                current = current.getNext();
            }
        }

        return duplicates;
    }

    // TODO: checkMasterPassword
    @Override
    public boolean checkMasterPassword(String enteredPassword) {
        return MASTER_PASSWORD.equals(enteredPassword);
    }

    @Override
    public String generatesafeRandomPassword(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        if (targetStringLength < 4) {
            targetStringLength = 4;
        }

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /*
    Used for testing, do not change
     */
    public Account[] getPasswords() {
        return _passwords;
    }
}
