package ac.simons.reactive.chains;

import java.math.BigInteger;
import java.util.function.Function;

public final class HashUtils {
	private static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();

	static final Function<byte[], String> ENCODE_BY_FORMAT = bytes -> String.format("%064x", new BigInteger(1, bytes));

	static final Function<byte[], String> ENCODE_WITH_GUAVA_ALGORITHM = bytes -> {
		final StringBuilder sb = new StringBuilder(2 * bytes.length);
		for (byte b : bytes) {
			sb.append(HEX_DIGITS[(b >> 4) & 0xf]).append(HEX_DIGITS[b & 0xf]);
		}
		return sb.toString();
	};

	static final Function<byte[], String> ENCODE_WITH_TO_HEX_STRING = bytes -> {
		final StringBuilder rv = new StringBuilder();
		for (byte b : bytes) {
			rv.append(Integer.toHexString((b & 0xff) + 0x100).substring(1));
		}
		return rv.toString();
	};
}
