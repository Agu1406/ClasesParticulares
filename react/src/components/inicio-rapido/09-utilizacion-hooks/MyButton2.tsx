/**
 * Primera aparición del botón controlado por el padre: recibe `count` y `onClick` por props,
 * típico al elevar estado y repartir varios botones con el mismo hook en `MyApp`.
 *
 * @see https://es.react.dev/learn
 */
import '../../styles.css';

type Props = { count: number; onClick: () => void };

export default function MyButton2({ count, onClick }: Props) {
    return (
        <div className="learn-react">
            <button type="button" onClick={onClick}>
                Soy un botón
            </button>
            <p>Valor actual {count}</p>
        </div>
    );
}
