package jp.co.aimsoft.attendance.sample.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * セキュリティ関連部品のユーティリティクラス.
 */
public final class SecurityUtil {

	/**
	 * 平文のパスワードとソルトから安全なパスワードを生成し、返却します
	 *
	 * @param password
	 *            平文のパスワード
	 * @return ハッシュ化されたパスワードとソルトのマップ
	 */
	public static Map<String, String> getHashedPasswordAndSalt(String password) {

		// ランダムな文字列を生成し、これをソルトとする。
		String salt = RandomStringUtils.randomAlphabetic(10);

		char[] passCharAry = password.toCharArray();
		byte[] hashedSalt = createHashedSalt(salt);

		// ストレッチング回数：10000
		PBEKeySpec keySpec = new PBEKeySpec(passCharAry, hashedSalt, 10000, 256);

		SecretKeyFactory skf;
		try {
			// SHA256を利用したストレッチングを行わせる
			skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		} catch (NoSuchAlgorithmException e) {
			// TODO エラーハンドリングは後程
			throw new RuntimeException(e);
		}

		SecretKey secretKey;
		try {
			// ハッシュ化したパスワードを取得
			secretKey = skf.generateSecret(keySpec);
		} catch (InvalidKeySpecException e) {
			// TODO エラーハンドリングは後程
			throw new RuntimeException(e);
		}
		byte[] passByteAry = secretKey.getEncoded();

		// 生成されたバイト配列を16進数の文字列に変換
		StringBuilder sb = new StringBuilder(64);
		for (byte b : passByteAry) {
			// 16進数2桁にしてappend。b & 0xffはbyteを正の数にしている
			sb.append(String.format("%02x", b & 0xff));
		}

		String hashedPassword = sb.toString();
		Map<String, String> passwordAndSalt = new HashMap<String, String>();
		passwordAndSalt.put("password", hashedPassword);
		passwordAndSalt.put("salt", salt);

		return passwordAndSalt;
	}

	/**
	 * ソルトをハッシュ化して返却します
	 * 
	 * @param salt
	 *            ソルト
	 * @return ハッシュ化されたバイト配列のソルト
	 */
	private static byte[] createHashedSalt(String salt) {

		MessageDigest messageDigest;

		try {
			// ソルト対象の文字列をハッシュ化する
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO エラーハンドリングは後程
			throw new RuntimeException(e);
		}

		messageDigest.update(salt.getBytes());
		return messageDigest.digest();
	}
}
